package com.example.projetoconfeitaria
import retrofit2.http.*

interface ApiService {

    //Funcionario
    @GET("funcionarios")
    suspend fun listar(): List<Funcionario>

    @GET("funcionarios/{id}")
    suspend fun obter(@Path("id") id: Int): Funcionario

    @POST("funcionarios")
    suspend fun criar(@Body f: Funcionario): Map<String, String> // message

    @PUT("funcionarios/{id}")
    suspend fun atualizar(@Path("id") id: Int, @Body f: Funcionario): Map<String, String>

    @DELETE("funcionarios/{id}")
    suspend fun excluir(@Path("id") id: Int): Map<String, String>

    //Produtos
    @GET("produtos")
    suspend fun listarProdutos(): List<Confeitaria>

    @GET("produtos/{id}")
    suspend fun obterProduto(@Path("id") id: Int): Confeitaria

    @POST("produtos")
    suspend fun criarProduto(@Body c: Confeitaria): Map<String, String>

    @PUT("produtos/{id}")
    suspend fun atualizarProduto(@Path("id") id: Int, @Body c: Confeitaria): Map<String, String>

    @DELETE("produtos/{id}")
    suspend fun excluirProduto(@Path("id") id: Int): Map<String, String>
}