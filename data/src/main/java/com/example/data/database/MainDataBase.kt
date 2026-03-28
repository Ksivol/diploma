package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.dao.CoolerDAO
import com.example.data.dao.CpuDAO
import com.example.data.dao.HardDriveDAO
import com.example.data.dao.MotherboardDAO
import com.example.data.dao.PcCaseDAO
import com.example.data.dao.PcDAO
import com.example.data.dao.PsuDAO
import com.example.data.dao.RamDAO
import com.example.data.dao.VideoCardDAO
import com.example.data.entities.CPUEntity
import com.example.data.entities.CoolerEntity
import com.example.data.entities.HardDriveEntity
import com.example.data.entities.MotherboardEntity
import com.example.data.entities.PSUEntity
import com.example.data.entities.PcCaseEntity
import com.example.data.entities.PcEntity
import com.example.data.entities.RAMEntity
import com.example.data.entities.VideoCardEntity
import com.example.data.entities.interlayer.ICPUEntity
import com.example.data.entities.interlayer.ICoolerEntity
import com.example.data.entities.interlayer.IHardDriveEntity
import com.example.data.entities.interlayer.IMotherboardEntity
import com.example.data.entities.interlayer.IPSUEntity
import com.example.data.entities.interlayer.IPcCaseEntity
import com.example.data.entities.interlayer.IRAMEntity
import com.example.data.entities.interlayer.IVideoCardEntity

@Database(
    entities = [
        CoolerEntity::class,
        ICoolerEntity::class,
        CPUEntity::class,
        ICPUEntity::class,
        HardDriveEntity::class,
        IHardDriveEntity::class,
        MotherboardEntity::class,
        IMotherboardEntity::class,
        PcCaseEntity::class,
        IPcCaseEntity::class,
        PSUEntity::class,
        IPSUEntity::class,
        RAMEntity::class,
        IRAMEntity::class,
        VideoCardEntity::class,
        IVideoCardEntity::class,
        PcEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class MainDataBase : RoomDatabase() {
    abstract fun getCoolerDAO(): CoolerDAO

    abstract fun getCpuDAO(): CpuDAO

    abstract fun getHardDriveDAO(): HardDriveDAO

    abstract fun getMotherboardDAO(): MotherboardDAO

    abstract fun getPcCaseDAO(): PcCaseDAO

    abstract fun getPsuDAO(): PsuDAO

    abstract fun getRamDAO(): RamDAO

    abstract fun getVideoCardDAO(): VideoCardDAO

    abstract fun getPcDao(): PcDAO

    companion object {
        private var INSTANCE: MainDataBase? = null

        fun getDatabase(context: Context): MainDataBase =
            INSTANCE ?: synchronized(this) {
                val instance =
                    Room
                        .databaseBuilder(
                            context = context,
                            klass = MainDataBase::class.java,
                            "main_database",
                        ).createFromAsset("database/db_test.db")
                        .build()
                INSTANCE = instance
                instance
            }
    }
}
