package lesson5;

import lesson6.db.dao.CategoriesMapper;
import lombok.SneakyThrows;
import org.example.lesson5.api.CategoryService;
import org.example.lesson5.dto.GetCategoryResponse;
import org.example.lesson5.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class GetCategoryTest extends AbstractTest{

    static CategoryService categoryService;
    @BeforeAll
    static void beforeAll() {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);
    }

    @SneakyThrows
    @Test
    void getCategoryByIdPositiveTest() {
        Response<GetCategoryResponse> response = categoryService.getCategory(1).execute();
               assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(1));
        assertThat(response.body().getTitle(), equalTo("Food"));
        response.body().getProducts().forEach(product ->
                assertThat(product.getCategoryTitle(), equalTo("Food")));
        lesson6.db.dao.CategoriesMapper categoriesMapper = getSession().getMapper(lesson6.db.dao.CategoriesMapper.class);
        lesson6.db.model.CategoriesExample example = new lesson6.db.model.CategoriesExample();
        example.createCriteria().andIdEqualTo(1);
        List<lesson6.db.model.Categories> list = categoriesMapper.selectByExample(example);
        System.out.println(categoriesMapper.countByExample(example));
        assertThat(list.get(0).getId(),equalTo(1));
    }
    @SneakyThrows
    @Test
    void getCategoryByIdNegativeTest() {
        Response<GetCategoryResponse> response = categoryService.getCategory(0).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(404));

}}
