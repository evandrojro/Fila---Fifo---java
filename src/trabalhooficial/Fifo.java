package trabalhooficial;

public class Fifo {
	public NodoDuplo inicio;
	public NodoDuplo fim;

	public Fifo(){
		inicio = null;
		fim = null;
}
//Op��o 1 Se a op��o 1 for selecionada o programa pede os dados de um funcion�rio e insere-os na lista, reapresenta o menu
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

	//Op��o 2 Se a op��o 2 for selecionada o programa retira um funcion�rio da lista, mostra a matr�cula do mesmo e reapresenta o menu;
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

	//Op��o 3 Se a op��o 3 for selecionada o programa reinicia a lista e reapresenta o menu;
	public void detonar() {
		inicio = null;
		fim = null;
	}

	//Op��o 4 Se a op��o 4 for selecionada o programa mostra as matr�culas existentes na lista e reapresenta o menu;
	public void mostrarMatriculas() {
		NodoDuplo aux = inicio;
		System.out.print("Matr�culas do in�cio ao fim: ");

		while (aux != null) {
			System.out.print(" " + aux.matricula);
			aux = aux.depois;
		}
		System.out.println();
	}

	//Op��o 5 Se a op��o 5 for selecionada o programa mostra as matr�culas na ordem inversa da fila e reapresenta o menu;
	public void mostrarInvertido() {
		NodoDuplo aux = fim;
		System.out.print("Matr�culas do fim ao in�cio: ");

		while (aux != null) {
			System.out.print(" " + aux.matricula);
			aux = aux.antes;
		}
		System.out.println();
	}

	//Op��o 6 Se a op��o 6 for selecionada o programa informa a m�dia de idade dos funcion�rios e reapresenta o menu;
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

	//Op��o 7 Se a op��o 7 for selecionada o programa o programa pede um n�mero de matr�cula, informa o setor de lota��o deste funcion�rio e reapresenta o menu;
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

	//Op��o 8 Se a op��o 8 for selecionada o programa informa o n�mero de matr�cula do funcion�rio mais velho e reapresenta o menu;
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

	//Op��o 9 Se a op��o 9 for selecionada o programa pede o n�mero de um setor, informa quantos funcion�rios est�o lotados nele e reapresenta o menu;
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