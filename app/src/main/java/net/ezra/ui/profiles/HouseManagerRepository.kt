package net.ezra.ui.profiles

class HouseManagerRepository {
    fun addHouseManager(houseManagers: HouseManagers) {
        ManagerobjectDataSource.addHouseManager(houseManagers)

    }
    fun getHouseManagers(): List<HouseManagers> {
        return ManagerobjectDataSource.getHouseManagers()
    }

}