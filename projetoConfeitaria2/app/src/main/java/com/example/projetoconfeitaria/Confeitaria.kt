package com.example.projetoconfeitaria

data class Confeitaria(
    val id_produto: Int? = null,
    var nome: String = "",
    var valor: Float = 0f,
    var peso: Float = 0f,
    var descricao: String = ""
)
