# DTO를 제대로(toEntitiy처리) 사용하지 않았다 ->
# 직렬화처리를 자동으로 수행, 
# 문제가 발생-> @Jsonignore 쓰게됨 : 

## 화면구성

<img width="1392" alt="image" src="https://github.com/user-attachments/assets/ea7fb1b7-6d91-447e-ae20-0d15440575e8">
<img width="1392" alt="image" src="https://github.com/user-attachments/assets/a42e9302-4c9d-48b3-ac3b-134e53e68ff8">
<img width="1392" alt="image" src="https://github.com/user-attachments/assets/0bed4787-0ac2-49b9-8872-d4622d11d087">

## 시스템 흐름 및 기능 구성

<img width="1392" alt="image" src="https://github.com/user-attachments/assets/163d4d00-8080-451c-9de5-d4cc3bca133d">


## 에러 
- 마지막에 고통받은 에러, @Jsonignore 한방에 해결되었다. 

<img width="1392" alt="image" src="https://github.com/user-attachments/assets/cf14d941-68b4-40f8-b6b3-8c0087f24166">
<img width="1392" alt="image" src="https://github.com/user-attachments/assets/db121589-9b24-4652-914a-3d5142c79d7b">



2024-09-10T09:16:26.023+09:00  INFO 1469 --- [coffeeLast] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2024-09-10T09:16:26.112+09:00  WARN 1469 --- [coffeeLast] [nio-8080-exec-1] .w.s.m.s.DefaultHandlerExceptionResolver : Ignoring exception, response committed already: org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)
2024-09-10T09:16:26.113+09:00  WARN 1469 --- [coffeeLast] [nio-8080-exec-1] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)]
2024-09-10T09:16:26.115+09:00  WARN 1469 --- [coffeeLast] [nio-8080-exec-2] .w.s.m.s.DefaultHandlerExceptionResolver : Ignoring exception, response committed already: org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)
2024-09-10T09:16:26.115+09:00  WARN 1469 --- [coffeeLast] [nio-8080-exec-2] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)]
2024-09-10T09:16:26.778+09:00  WARN 1469 --- [coffeeLast] [nio-8080-exec-3] .w.s.m.s.DefaultHandlerExceptionResolver : Ignoring exception, response committed already: org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)
2024-09-10T09:16:26.778+09:00  WARN 1469 --- [coffeeLast] [nio-8080-exec-3] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)]
2024-09-10T09:16:26.787+09:00  WARN 1469 --- [coffeeLast] [nio-8080-exec-4] .w.s.m.s.DefaultHandlerExceptionResolver : Ignoring exception, response committed already: org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)
2024-09-10T09:16:26.788+09:00  WARN 1469 --- [coffeeLast] [nio-8080-exec-4] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)]
2024-09-10T09:23:23.600+09:00  WARN 1469 --- [coffeeLast] [l-1 housekeeper] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Thread starvation or clock leap detected (housekeeper delta=3m30s500ms).
2024-09-10T09:25:44.591+09:00  WARN 1469 --- [coffeeLast] [nio-8080-exec-7] .w.s.m.s.DefaultHandlerExceptionResolver : Ignoring exception, response committed already: org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)
2024-09-10T09:25:44.591+09:00  WARN 1469 --- [coffeeLast] [nio-8080-exec-7] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)]
2024-09-10T09:25:44.602+09:00  WARN 1469 --- [coffeeLast] [nio-8080-exec-8] .w.s.m.s.DefaultHandlerExceptionResolver : Ignoring exception, response committed already: org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)
2024-09-10T09:25:44.602+09:00  WARN 1469 — [coffeeLast] [nio-8080-exec-8] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Document nesting depth (1001) exceeds the maximum allowed (1000, from `StreamWriteConstraints.getMaxNestingDepth()`)]
