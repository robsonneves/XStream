import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import xstream.Produto;

public class ProdutoTest {

	@Test
	public void deveGerarOXmlComONomePrecoEDescricaoAdequados() {
		
		String xmlEsperado ="<produto codigo=\"1587\">\n" +
							"  <nome>geladeira</nome>\n" +
							"  <preco>1000.0</preco>\n" +
							"  <descri��o>geladeira duas portas</descri��o>\n" +
							"</produto>";
		
		Produto geladeira = new Produto("geladeira", 1000.0, "geladeira duas portas", 1587);
			
		XStream xstream = new XStream();
		xstream.alias("produto", Produto.class);
		xstream.aliasField("descri��o", Produto.class, "descricao");
		xstream.useAttributeFor(Produto.class, "codigo");
		String xmlGerado = xstream.toXML(geladeira);

		assertEquals(xmlEsperado, xmlGerado);
		
	}
	
	
}
