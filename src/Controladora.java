
public class Controladora {
	private Tempo tempo;

	public String verificarCampos(String horas, String minutos) {
		
		return "";
	}

	public Tempo criarTempo(String horas, String minutos, String inicial) {
		try {
			double inicialText = Double.parseDouble(inicial);
			if(horas.isEmpty()) horas = "0";
			if(minutos.isEmpty()) minutos = "0";
			return  new Tempo(Integer.parseInt(horas), Integer.parseInt(minutos),(int)inicialText);
			
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
