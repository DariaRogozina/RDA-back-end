package lesson5;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;

import org.example.lesson5.api.ProductService;

import org.example.lesson5.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductsTest {
    static ProductService productService;
    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @SneakyThrows
    @Test
    void getProductsTest() {
        Response<ResponseBody> response = productService.getProducts().execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), equalTo(200));

    }}



