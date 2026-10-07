\# WeatherApp



App Android feito em Kotlin com Jetpack Compose, desenvolvido nas práticas da disciplina \*\*Programação para Dispositivos Móveis\*\* (IFPE Campus Recife, curso de Análise e Desenvolvimento de Sistemas, Prof. Ramide Dantas).



Aluno: Mattheeus Dantas



O app foi construído de forma incremental: cada prática continua a anterior, então o código atual contém as Práticas 1, 2 e 3.



\## Prática 1: Activities, Compose e Intents



Telas de login e cadastro, e navegação entre Activities usando Intents.



\- `LoginActivity.kt`: tela de login (e-mail e senha), botão Login habilitado só com os campos preenchidos, botão Limpar e botão para abrir o cadastro.

\- `RegisterActivity.kt`: tela de cadastro (nome, e-mail, senha e confirmação), botão Registrar habilitado só se todos os campos estiverem preenchidos e as senhas forem iguais.

\- `MainActivity.kt`: tela principal aberta após o login.

\- `ui/Components.kt`: componentes reutilizáveis `DataField` e `PasswordField` (desafio da prática).



Conceitos: Activity, `@Composable`, estado com `mutableStateOf` e `rememberSaveable`, `Column` e `Row`, `Intent`, `AndroidManifest.xml`.



\## Prática 2: Navegação com barra inferior



Navegação entre três páginas dentro da mesma Activity, usando Navigation Compose.



\- `ui/nav/BottomNavItem.kt`: itens da barra inferior (Início, Favoritos, Mapa) e as rotas.

\- `ui/nav/BottomNavBar.kt`: barra de navegação inferior.

\- `ui/nav/MainNavHost.kt`: associa cada rota à sua página.

\- `ui/HomePage.kt`, `ui/ListPage.kt`, `ui/MapPage.kt`: as três páginas.

\- `MainActivity.kt`: `Scaffold` com barra superior, barra inferior e botão flutuante.



Conceitos: `NavController`, `NavHost`, rotas tipadas com `@Serializable`, `Scaffold`.



\## Prática 3: Listas e ViewModel



Lista de cidades favoritas que pode ser adicionada e removida pelo usuário.



\- `model/City.kt`: `data class City` (nome, clima e localização).

\- `ui/ListPage.kt`: lista com `LazyColumn` e o item visual `CityItem`, com botão X para remover.

\- `MainViewModel.kt`: guarda a lista de cidades e oferece `add` e `remove`.

\- `ui/CityDialog.kt`: diálogo para adicionar uma nova cidade, aberto pelo botão flutuante.



Conceitos: `data class`, `LazyColumn`, `toMutableStateList`, `ViewModel`, state hoisting, `Dialog`.



\## Como rodar



1\. Abrir a pasta do projeto no Android Studio.

2\. Aguardar a sincronização do Gradle.

3\. Escolher um dispositivo (celular com depuração USB ou emulador) e rodar com Shift + F10.

