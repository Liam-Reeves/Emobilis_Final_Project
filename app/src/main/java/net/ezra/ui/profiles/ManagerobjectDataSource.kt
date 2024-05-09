package net.ezra.ui.profiles

object ManagerobjectDataSource {
    private val houseManagers = mutableListOf<HouseManagers>()

    fun addHouseManager(houseManagers: HouseManagers) {
        ManagerobjectDataSource.houseManagers.add(houseManagers)

    }
    fun getHouseManagers(): List<HouseManagers> {
        return houseManagers.filter { it.availability == "Available" }
    }


}
