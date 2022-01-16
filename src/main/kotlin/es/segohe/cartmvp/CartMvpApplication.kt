package es.segohe.cartmvp

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
    info = Info(
        title = "Cart MVP",
        version = "v1",
        description = "Building MVP without DB",
        contact = Contact(
            name = "Sergio Gómez",
            url = "https://github.com/Sergiogh14",
            email = "sergio.gomez.develop@gmail.com"
        )
    )
)
class CartMvpApplication

fun main(args: Array<String>) {
    runApplication<CartMvpApplication>(*args)
}
