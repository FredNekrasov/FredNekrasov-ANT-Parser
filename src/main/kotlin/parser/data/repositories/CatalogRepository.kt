package parser.data.repositories

import io.ktor.client.request.*
import kotlinx.coroutines.*
import parser.data.remote.WebAPI
import parser.domain.models.Catalog
import parser.domain.repositories.IRepository

class CatalogRepository(
    private val api: WebAPI
) : IRepository<Catalog, Int> {
    private val scope = CoroutineScope(Dispatchers.IO)
    private val url = "https://alexander-nevsky.ru/catalog/"
    private var list = emptyList<Catalog>()
    override fun getList(): List<Catalog> {
        TODO("Not yet implemented")
    }
    override fun insert(model: Catalog) {
        scope.launch {
            api.getHttpClient().post(url)
        }
    }
    override fun delete(id: Int) {
        scope.launch {
            api.getHttpClient().delete(url)
        }
    }
}