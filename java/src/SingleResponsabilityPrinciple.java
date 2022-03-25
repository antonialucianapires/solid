public class SingleResponsabilityPrinciple {

    public static void main(String[] args) {
        var boletoSemSolid = new BoletoSemSolid();
        boletoSemSolid.gerar();

        var emailService = new EmailServiceImplementacao();
        var boletoComSolid = new BoletoComSolid(emailService);
        boletoComSolid.gerar();
    }

}

class BoletoSemSolid {
    void gerar() {
        System.out.println("[sem SOLID] Boleto gerado com sucesso!");
        enviarEmail();
    }

    //A funcionalidade de gerar boleto é responsabilidade da classe boleto.
    void enviarEmail() {
        System.out.println("[sem SOLID] E-mail enviado com sucesso");
    }
}

class BoletoComSolid {
    
    private IEmailService emailService;

    BoletoComSolid(IEmailService emailService) {
        this.emailService = emailService;
    }

    //Area: pagamento
    void gerar() {
        System.out.println("[com SOLID] Boleto gerado com sucesso!");
        //Temos aqui a classe boleto delegando a responsabilidade de saber enviar e-mail para a interface IEmail
        //Area: comunicação
        emailService.enviar();
    }
}

class EmailServiceImplementacao implements IEmailService {

    @Override
    public void enviar() {
        System.out.println("[com SOLID] E-mail enviado com sucesso");

    }

}

interface IEmailService {
    void enviar();
}