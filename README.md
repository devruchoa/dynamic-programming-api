# Projeto de Comparação de Algoritmos de Programação Dinâmica - Problema da Mochila

Este projeto tem como objetivo comparar dois algoritmos para resolver o **Problema da Mochila (Knapsack)** utilizando técnicas de **programação dinâmica**. Foram implementadas duas abordagens: uma solução **recursiva com memoização** e uma solução **iterativa**. O projeto está dividido em duas partes: uma camada de serviço no backend responsável pelos cálculos dos algoritmos e um frontend para visualização dos resultados.

## Estrutura do Projeto

### Backend
A camada de serviço no backend é responsável pela implementação dos algoritmos de Programação Dinâmica. Foram implementadas duas versões do algoritmo da mochila:
- **Algoritmo Recursivo com Memoização**: Utiliza a técnica de memoização para armazenar resultados de subproblemas já resolvidos, evitando cálculos redundantes.
- **Algoritmo Iterativo**: Resolve o problema de forma iterativa, utilizando uma tabela para armazenar os resultados intermediários e construir a solução de baixo para cima.

Ambos os algoritmos recebem a mesma entrada, que é fornecida pelo usuário na view, garantindo uma comparação justa entre as abordagens.

### Frontend
O frontend foi desenvolvido para facilitar a interação com os algoritmos, permitindo que o usuário forneça o tamanho da entrada desejada. Ele também exibe os resultados das execuções e os tempos de execução médios de cada algoritmo. Os resultados são apresentados em gráficos, onde o eixo horizontal representa o tamanho da entrada e o eixo vertical o tempo de execução médio.

Este é o link do repositório do front caso tenha alguma dúvida: [REPO VIEW](https://github.com/devruchoa/dynamic-programming-view)

### Aqui estão os gráficos pedidos para a seguinte entrada -> Sizes = 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 e Número de Amostras = 10 depois 100 depois 100, qualquer dúvida pode entrar em contato diretamente comigo, ok? Obrigado

![Antes de executar o request](https://github.com/devruchoa/dynamic-programming-api/blob/master/images/view-inicial.png)

![Antes de executar o request](https://github.com/devruchoa/dynamic-programming-api/blob/master/images/simulation3.png)

![Antes de executar o request](https://github.com/devruchoa/dynamic-programming-api/blob/master/images/simulation2.png)

![Antes de executar o request](https://github.com/devruchoa/dynamic-programming-api/blob/master/images/simulation1.png)
