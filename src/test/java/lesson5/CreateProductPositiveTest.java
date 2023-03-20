package lesson5;

import com.github.javafaker.Faker;
import org.example.lesson5.api.ProductService;
import org.example.lesson5.dto.Product;
import org.example.lesson5.utils.RetrofitUtils;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class CreateProductPositiveTest {

    static ProductService productService;
    Product product = null;
    Faker faker = new Faker();
    int id;
//    String titleProduct = null;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

 @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));
    }

    @Test
    void createProductInFoodCategoryTest() throws IOException {
        Response<Product> response = productService.createProduct(product)
                .execute();
        id =  response.body().getId();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), equalTo(201));


        product = new Product()
                .withId(id)
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));
        Response<Product> response1 = productService.modifyProduct(product)
                .execute();

//        titleProduct = response1.body().getTitle();
        assertThat(response1.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), equalTo(201));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));


        Response<Product> response2 = productService.getProductById(id).execute();
        assertThat(response2.isSuccessful(), CoreMatchers.is(true));
        assertThat(response2.code(), equalTo(200));
//        assertThat(response2.body().getTitle(),equals(titleProduct));
    }


    @SneakyThrows
    @AfterEach
    void tearDown() {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));

        Response<Product> response1 = productService.getProductById(id).execute();
        assertThat(response1.isSuccessful(), CoreMatchers.is(false));
        assertThat(response1.code(), equalTo(404));
    }



}
