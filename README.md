# Demo Backend View Response
## Using Spring Boot With Kotlin
### #Contributor 
- Samrach
 ```kotlin
  interface ViewController {
    companion object {
        fun withView(mapper: ObjectMapper, data: Any?, viewClazz: Class<*>): JsonNode {
            val node = mapper.writerWithView(viewClazz).writeValueAsString(data)
            return mapper.readTree(node)
        }
    }
}
```
