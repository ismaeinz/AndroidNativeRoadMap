الأول بتعرف الـModel
بعدين الـinterface


=>
interface GymsApiServices {

    @GET("gyms.json")
    suspend fun getGyms(): List<Gym>
}


=>
class GymsViewModel() : ViewModel() {
var state by mutableStateOf(emptyList<Gym>())

private var apiServices: GymsApiServices

private val errorHandler =
CoroutineExceptionHandler { _, throwable -> throwable.printStackTrace() }

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory
                    .create()
            )
            .baseUrl(
                "https://cairo-gyms-f29c8-default-rtdb.firebaseio.com/"
            ).build()
        apiServices = retrofit.create(GymsApiServices::class.java)
        getGyms()
    }

    private fun getGyms() {
        viewModelScope.launch(errorHandler) {
            val gyms = getGymsFromRemoteDb()
            withContext(Dispatchers.Main) {
                state = gyms.restoredSelectedGyms()
            }


        }

    }

    private suspend fun getGymsFromRemoteDb() = withContext(Dispatchers.IO) {
        apiServices.getGyms()
    }


=>
@Composable
fun GymsScreen() {
val vmGyms: GymsViewModel = viewModel()

    LazyColumn {
        items(vmGyms.state) { gym ->
            GymItem(gym) { gymId ->
                vmGyms.toggleFavouriteState(gymId)
            }
        }

    }
}

