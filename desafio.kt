// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, var duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, var nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        // TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        for (usuario in usuarios)
        	inscritos.add(usuario)
    }
    
    fun totalDuracao(): Int {
        var total = 0
        for (conteudo in conteudos) {
            total += conteudo.duracao
        }
        return total
    }
}

fun main() {
    // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    // TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val usuario1: Usuario = Usuario("João", "joao@email.com")
    val usuario2: Usuario = Usuario("Antonio", "antonio@email.com")
    val usuario3: Usuario = Usuario("Pedro", "pedro@email.com")
    val usuario4: Usuario = Usuario("Marcos", "marcos@email.com")
    
    val conteudo1: ConteudoEducacional = ConteudoEducacional("kotlin Syntax")
    val conteudo2: ConteudoEducacional = ConteudoEducacional("kotlin Variables")
    val conteudo3: ConteudoEducacional = ConteudoEducacional("kotlin Data Types")
    
    val conteudos = listOf(conteudo1, conteudo2, conteudo3)    
    
    val formacaoKotlin: Formacao = Formacao("Kotlin para iniciantes", conteudos, Nivel.BASICO)
    
    formacaoKotlin.matricular(usuario1, usuario2, usuario3)
    
    val conteudoJava1: ConteudoEducacional = ConteudoEducacional("Java Syntax", 30)
    val conteudoJava2: ConteudoEducacional = ConteudoEducacional("Java Data Types")
    val conteudoJava3: ConteudoEducacional = ConteudoEducacional("Java Math")
    
    val conteudosJava = listOf(conteudoJava1, conteudoJava2, conteudoJava3)
    
    val formacaoJava = Formacao("Java para iniciantes", conteudosJava, Nivel.BASICO)
    
    formacaoJava.matricular(usuario3, usuario4)
    
    for (usuario in formacaoKotlin.inscritos) {
        println("O usuário ${usuario.nome} matriculou-se na formação ${formacaoKotlin.nome} de nível ${formacaoKotlin.nivel} com duração total de ${formacaoKotlin.totalDuracao()} horas")
    }
    
    for (usuario in formacaoJava.inscritos) {
        println("O usuário ${usuario.nome} matriculou-se na formação ${formacaoJava.nome} de nível ${formacaoJava.nivel} com duração total de ${formacaoJava.totalDuracao()} horas")
    }
}
