package edu.portfolio.coffeelast.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSconfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowedOrigins("*");
    }
}

//ERROR -> 이건 왜 나는거지 > ?
//Request failed with status code 404
//AxiosError: Request failed with status code 404
//at settle (http://localhost:3000/static/js/bundle.js:55864:12)
//        at XMLHttpRequest.onloadend (http://localhost:3000/static/js/bundle.js:54515:66)
//        at Axios.request (http://localhost:3000/static/js/bundle.js:55014:41)

// - 아래 두 에러는, 프로덕트에 내용을 너무 많이 넣었더니,JSON 문서 중첩 깊이 초과:
// => 디비 비우니까 해결
// ERROR
//products.map is not a function
//TypeError: products.map is not a function
//    at ProductList (http://localhost:3000/static/js/bundle.js:366:26)

// [org.springframework.http.converter.HttpMessageNotWritableException:
//  Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed
//  (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)]
