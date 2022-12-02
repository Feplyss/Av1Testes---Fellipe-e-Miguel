package sistemadetestes.pageObject;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{
    @FindBy(id = "btn-adicionar")
    public WebElement buttonCriar;
    @FindBy(id  = "codigo")
    public WebElement inputCodigo;
    @FindBy(id = "nome")
    public WebElement inputNome;
    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;
    @FindBy(id = "valor")
    public WebElement inputValor;
    @FindBy(id = "data")
    public WebElement inputData;
    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;
    @FindBy(id = "btn-sair")
    public WebElement buttonSair;
    @FindBy(className = "table")
    public WebElement tabela;
    @FindBy(id = "mensagem")
    public WebElement mensagem;

	public ProdutoPO(WebDriver driver) {
		super(driver);
	}

    public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}

    public void duploClick(){
        buttonCriar.click();
        buttonCriar.click();
    }

    public void cadastrar(String codigo, String nome, String quantidade, String valor, String data) {
		escrever(inputCodigo, codigo);
		escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade);
        escrever(inputValor, valor);
        escrever(inputData, data);
        buttonSalvar.click();
	}
}
