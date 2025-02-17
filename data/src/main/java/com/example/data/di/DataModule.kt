package com.example.data.di

import android.content.Context
import com.example.data.dao.CoolerDAO
import com.example.data.dao.CpuDAO
import com.example.data.dao.HardDriveDAO
import com.example.data.dao.MotherboardDAO
import com.example.data.dao.PcCaseDAO
import com.example.data.dao.PcDAO
import com.example.data.dao.PsuDAO
import com.example.data.dao.RamDAO
import com.example.data.dao.VideoCardDAO
import com.example.data.database.MainDataBase
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun getDatabase(context: Context): MainDataBase = MainDataBase.getDatabase(context)

    @Provides
    fun getCoolerDAO(dataBase: MainDataBase): CoolerDAO = dataBase.getCoolerDAO()

    @Provides
    fun getCpuDAO(dataBase: MainDataBase): CpuDAO = dataBase.getCpuDAO()

    @Provides
    fun getMotherboardDAO(dataBase: MainDataBase): MotherboardDAO = dataBase.getMotherboardDAO()

    @Provides
    fun getHardDriveDAO(dataBase: MainDataBase): HardDriveDAO = dataBase.getHardDriveDAO()

    @Provides
    fun getPcCaseDAO(dataBase: MainDataBase): PcCaseDAO = dataBase.getPcCaseDAO()

    @Provides
    fun getPcDAO(dataBase: MainDataBase): PcDAO = dataBase.getPcDao()

    @Provides
    fun getPsuDAO(dataBase: MainDataBase): PsuDAO = dataBase.getPsuDAO()

    @Provides
    fun getRamDAO(dataBase: MainDataBase): RamDAO = dataBase.getRamDAO()

    @Provides
    fun getVideoCardDAO(dataBase: MainDataBase): VideoCardDAO = dataBase.getVideoCardDAO()
}
