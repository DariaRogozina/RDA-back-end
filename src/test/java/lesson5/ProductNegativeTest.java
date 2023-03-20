package lesson5;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.example.lesson5.api.ProductService;
import org.example.lesson5.dto.Product;
import org.example.lesson5.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.*;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class ProductNegativeTest {
    static ProductService productService;
    Product product = null;
    Faker faker = new Faker();
    int id;

    @BeforeAll
    static void beforeAll() {

        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @Test
    void createProductInFoodCategoryNegativeTest1() throws IOException {
        product = new Product()
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));
        Response<Product> response = productService.createProduct(product)
                .execute();
        id =  response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));
        assertThat(response.code(), equalTo(201));
    }

    @Test
    void createProductInFoodCategoryNegativeTest2() throws IOException {
        product = new Product();

        Response<Product> response = productService.createProduct(product)
                .execute();

       assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(500));

    }

    @Test
    void modifyProductInFoodCategoryNegativeTest1() throws IOException {
        product = new Product()
                .withId(1000)
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));
        Response<Product> response = productService.modifyProduct(product)
                .execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(400));
    }
    @Test
    void modifyProductInFoodCategoryNegativeTest2() throws IOException {
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));
        Response<Product> response = productService.createProduct(product)
                .execute();
        id =  response.body().getId();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), equalTo(201));
        product = new Product()
                .withId(id)
                .withPrice((int) (Math.random() * 10000));
        Response<Product> response1 = productService.modifyProduct(product)
                .execute();
        assertThat(response1.isSuccessful(), CoreMatchers.is(false));
        assertThat(response1.code(), equalTo(500));

    }

    @Test
    void getProductByIdNegativeTest() throws IOException {
        Response<Product> response = productService.getProductById(1000).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(404));
    }


    @Test
    void deleteProductNegativeTest() throws IOException {
        Response<ResponseBody> response = productService.deleteProduct(100).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(500));
    }
    @SneakyThrows
    @AfterEach
    void tearDown() {
        if(id>0){
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));

}}}
