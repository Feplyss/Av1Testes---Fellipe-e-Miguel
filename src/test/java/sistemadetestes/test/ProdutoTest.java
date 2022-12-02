package sistemadetestes.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sistemadetestes.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseText{
    
    private static ProdutoPO produtoPage;

    @BeforeClass
    public static void prepararTestes(){
        produtoPage = new ProdutoPO(driver);
    }

    @Test
    public void TC001_deveCadastrarProdutoComTodasAsCredenciais(){
        produtoPage.buttonCriar.click();
        produtoPage.buttonCriar.click();
        produtoPage.cadastrar("100", "Saco de batata", "10", "10,00", "22/12/2022");
        String texto = produtoPage.tabela.getText();
        assertTrue(texto, texto.contains("100"));
        assertTrue(texto, texto.contains("Saco de batata"));
        assertTrue(texto, texto.contains("10"));
        assertTrue(texto, texto.contains("10,00"));
        assertTrue(texto, texto.contains("2022-12-22"));
        
    }

    @Test
    public void TC002_naoDeveCadastrarProdutoComCodigoVazio(){
        produtoPage.buttonSair.click();
        produtoPage.buttonCriar.click();
        produtoPage.cadastrar("", "Caixa de leite", "30", "3,00", "23/12/2022");
        assertEquals(produtoPage.mensagem.getText(), "Todos os campos são obrigatórios para o cadastro!");
    }

    @Test
    public void TC003_naoDeveCadastrarProdutoComValorVazio(){
        produtoPage.buttonSair.click();
        produtoPage.buttonCriar.click();
        produtoPage.cadastrar("300", "Detergente", "25", "", "26/12/2022");
        assertEquals(produtoPage.mensagem.getText(), "Todos os campos são obrigatórios para o cadastro!");
    }
}
