/*
 * Tipo de Exame feito no Hospital
 */
package hospitalveterinario.cliente.exames;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class Diagnostico {
    private String suspeitaDiagnostica, complementares, diagnosticoDefinitivo;
    private boolean notificacaoObrigatoria = false;

    public Diagnostico() {
    }

    public String getSuspeitaDiagnostica() {
        return suspeitaDiagnostica;
    }

    public void setSuspeitaDiagnostica(String suspeitaDiagnostica) {
        this.suspeitaDiagnostica = suspeitaDiagnostica;
    }

    public String getComplementares() {
        return complementares;
    }

    public void setComplementares(String complementares) {
        this.complementares = complementares;
    }

    public String getDiagnosticoDefinitivo() {
        return diagnosticoDefinitivo;
    }

    public void setDiagnosticoDefinitivo(String diagnosticoDefinitivo) {
        this.diagnosticoDefinitivo = diagnosticoDefinitivo;
    }

    public boolean isNotificacaoObrigatoria() {
        return notificacaoObrigatoria;
    }

    public void setNotificacaoObrigatoria(boolean notificacaoObrigatoria) {
        this.notificacaoObrigatoria = notificacaoObrigatoria;
    }
    
}
