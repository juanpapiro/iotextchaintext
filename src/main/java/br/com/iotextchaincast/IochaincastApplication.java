package br.com.iotextchaincast;

import br.com.iotextchaincast.entity.TypeHandler;
import br.com.iotextchaincast.external.dto.Example;
import br.com.iotextchaincast.infrastructue.IOTextChainCastController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class IochaincastApplication {

	@Autowired
	private List<TypeHandler> typeHandlerList;

	public static void main(String[] args) {
		SpringApplication.run(IochaincastApplication.class, args);
	}

	@Bean
	public Object run() {
		IOTextChainCastController ioChainCastController = new IOTextChainCastController(typeHandlerList);
		Example example = (Example) ioChainCastController.toObject("0201203123TESTE", new Example());
		System.out.println("Objeto formatado: " + example.toString());
		String txtFormatter = ioChainCastController.toText(example);
		System.out.println("Texto formatado: " + txtFormatter);
		return example;
	}


}
