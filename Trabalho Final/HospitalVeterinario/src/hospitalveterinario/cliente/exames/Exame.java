/*
 *  Tipo de Exame feito no Hospital
 */
package hospitalveterinario.cliente.exames;

/**
 * @author Daiane Silva e João Felipe Freitas
 */
public class Exame {
    private Anamnese anamnese = new Anamnese();
    private Diagnostico diagnostico = new Diagnostico();
    private ExameFisico exameFisico = new ExameFisico();
    private Fisiologico fisiologico = new Fisiologico();

    public Exame() {
    }
    
    public Anamnese getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public ExameFisico getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(ExameFisico exameFisico) {
        this.exameFisico = exameFisico;
    }

    public Fisiologico getFisiologico() {
        return fisiologico;
    }

    public void setFisiologico(Fisiologico fisiologico) {
        this.fisiologico = fisiologico;
    } 
}
