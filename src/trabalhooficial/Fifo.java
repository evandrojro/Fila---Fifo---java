package trabalhooficial;

public class Fifo {
	public NodoDuplo inicio;
	public NodoDuplo fim;

	public Fifo(){
		inicio = null;
		fim = null;
}
//Opção 1 Se a opção 1 for selecionada o programa pede os dados de um funcionário e insere-os na lista, reapresenta o menu
	public void inserir(int matricula, int idade, int setor) {
		NodoDuplo aux = new NodoDuplo(matricula, idade, setor);
		if (inicio == null) {
			inicio = aux;
		} else {
			aux.antes = fim;
			fim.depois = aux;
		}
		fim = aux;
	}

	//Opção 2 Se a opção 2 for selecionada o programa retira um funcionário da lista, mostra a matrícula do mesmo e reapresenta o menu;
	public int retirar() {
		Integer aux = null;
		if (fim != null) {
			aux = inicio.matricula;
			inicio = inicio.depois;
			if (inicio != null) {
				inicio.antes = null;
			} else {
				fim = null;
			}
		}
		return aux;
		
	}

	//Opção 3 Se a opção 3 for selecionada o programa reinicia a lista e reapresenta o menu;
	public void detonar() {
		inicio = null;
		fim = null;
	}

	//Opção 4 Se a opção 4 for selecionada o programa mostra as matrículas existentes na lista e reapresenta o menu;
	public void mostrarMatriculas() {
		NodoDuplo aux = inicio;
		System.out.print("Matrículas do início ao fim: ");

		while (aux != null) {
			System.out.print(" " + aux.matricula);
			aux = aux.depois;
		}
		System.out.println();
	}

	//Opção 5 Se a opção 5 for selecionada o programa mostra as matrículas na ordem inversa da fila e reapresenta o menu;
	public void mostrarInvertido() {
		NodoDuplo aux = fim;
		System.out.print("Matrículas do fim ao início: ");

		while (aux != null) {
			System.out.print(" " + aux.matricula);
			aux = aux.antes;
		}
		System.out.println();
	}

	//Opção 6 Se a opção 6 for selecionada o programa informa a média de idade dos funcionários e reapresenta o menu;
	public float mediaIdade() {
		int cont = 0; 
		int soma = 0;
		NodoDuplo aux = inicio;
		while (aux != null) {
			soma += aux.idade;
			cont ++;
			aux = aux.depois;
		}
		float media = soma / cont;
		return media;
	}

	//Opção 7 Se a opção 7 for selecionada o programa o programa pede um número de matrícula, informa o setor de lotação deste funcionário e reapresenta o menu;
	public int acharSetor(int matricula) {
		NodoDuplo aux = inicio;
		while (aux != null) {
			if (aux.matricula == matricula) {
				return aux.setor;
			} else {
				aux = aux.depois;
			}
		}
		return 0;	
	}

	//Opção 8 Se a opção 8 for selecionada o programa informa o número de matrícula do funcionário mais velho e reapresenta o menu;
	public int acharIdoso() {
		NodoDuplo aux;

		if (inicio.depois != null) {
			aux = inicio.depois;
		} else {
			return inicio.matricula;
		}

		NodoDuplo idoso = inicio;
		while (aux != null) {
			if (aux.idade > idoso.idade) {
				idoso = aux;
			}
			aux = aux.depois;
		}
		return idoso.matricula;
	}

	//Opção 9 Se a opção 9 for selecionada o programa pede o número de um setor, informa quantos funcionários estão lotados nele e reapresenta o menu;
	public int quantosNoSetor (int setor) {
		NodoDuplo aux = inicio;
		int cont = 0;
		while (aux != null) {
			if (aux.setor == setor) {
				cont ++;
			}
			aux = aux.depois;
		}
		return cont;
	} } 