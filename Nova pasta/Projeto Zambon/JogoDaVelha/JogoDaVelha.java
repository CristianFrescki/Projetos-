public class JogoDaVelha {
	private static final char[][] tabuleiro = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
	private static final char JOGADOR_X = 'X';
	private static final char JOGADOR_O = 'O';

	public static void main(String[] args) {
		// Jogadas prC)-definidas: {linha, coluna}
		int[][] jogadas = {
			{1, 1}, {1, 2}, {2, 1},
			{2, 2}, {3, 1}, {1, 3},
			{3, 2}, {3, 3}, {2, 3}
		};

		char jogadorAtual = JOGADOR_X;
		boolean jogoAtivo = true;
		int jogadaIndex = 0;

		while (jogoAtivo && jogadaIndex < jogadas.length) {
			imprimirTabuleiro();

			// Obter a prC3xima jogada
			int linha = jogadas[jogadaIndex][0] - 1;
			int coluna = jogadas[jogadaIndex][1] - 1;
			jogadaIndex++;

			System.out.println("Jogador " + jogadorAtual + " jogou em: " + (linha + 1) + ", " + (coluna + 1));

			if (coordenadaValida(linha, coluna)) {
				if (tabuleiro[linha][coluna] == ' ') {
					tabuleiro[linha][coluna] = jogadorAtual;

					if (verificarVencedor(jogadorAtual)) {
						imprimirTabuleiro();
						System.out.println("ParabC)ns, Jogador " + jogadorAtual + " venceu!");
						jogoAtivo = false;
					} else if (tabuleiroCompleto()) {
						imprimirTabuleiro();
						System.out.println("O jogo empatou!");
						jogoAtivo = false;
					} else {
						jogadorAtual = (jogadorAtual == JOGADOR_X) ? JOGADOR_O : JOGADOR_X;
					}
				} else {
					System.out.println("Essa posiC'C#o jC! estC! ocupada.");
				}
			} else {
				System.out.println("Coordenada invC!lida.");
			}
		}

		if (jogoAtivo) {
			imprimirTabuleiro();
			System.out.println("O jogo terminou sem vencedor.");
		}
	}

	private static void imprimirTabuleiro() {
		System.out.println("\nTabuleiro:");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + tabuleiro[i][j]);
				if (j < 2) System.out.print(" |");
			}
			System.out.println();
			if (i < 2) System.out.println("---+---+---");
		}
	}

	private static boolean coordenadaValida(int linha, int coluna) {
		return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3;
	}

	private static boolean verificarVencedor(char jogador) {
		// Verifica linhas e colunas
		for (int i = 0; i < 3; i++) {
			if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
			        (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
				return true;
			}
		}

		// Verifica diagonais
		return (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
		       (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador);
	}

	private static boolean tabuleiroCompleto() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tabuleiro[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
}
