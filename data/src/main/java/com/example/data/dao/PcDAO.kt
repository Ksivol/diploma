package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.PcEntity
import com.example.data.entities.PcWithData
import kotlinx.coroutines.flow.Flow


@Dao
interface PcDAO {
    @Query("""SELECT Pc.id, Pc.name, Pc.price,
            cpus.id as cpu_id, cpus.name as cpu_name, cpus.price as cpu_price, cpus.socket as cpu_socket, cpus.clockRate as cpu_clockRate, cpus.wattage as cpu_wattage, cpus.photo as cpu_photo, 
            coolers.id as clr_id, coolers.name as clr_name, coolers.price as clr_price, coolers.heatSink as clr_heatSink, coolers.size as clr_size, coolers.socket as clr_socket, coolers.photo as clr_photo, 
            hard_drives.id as hd_id, hard_drives.name as hd_name, hard_drives.price as hd_price, hard_drives.capacity as hd_capacity, hard_drives.type as hd_type, hard_drives.size as hd_size, hard_drives.overwrite as hd_overwrite, hard_drives.photo as hd_photo, 
            motherboards.id as mthb_id, motherboards.name as mthb_name, motherboards.price as mthb_price, motherboards.size as mthb_size, motherboards.socket as mthb_socket, motherboards.photo as mthb_photo, 
            pc_cases.id as pcc_id, pc_cases.name as pcc_name, pc_cases.price as pcc_price, pc_cases.size as pcc_size, pc_cases.photo as pcc_photo, 
            psus.id as psu_id, psus.name as psu_name, psus.price as psu_price, psus.wattage as psu_wattage, psus.pinCPU as psu_pinCPU, psus.pinPCIE as psu_pinPCIE, psus.photo as psu_photo, 
            rams.id as ram_id, rams.name as ram_name, rams.price as ram_price, rams.clockRate as ram_clockRate, rams.type as ram_type, rams.photo as ram_photo, 
            video_cards.id as vdcrd_id, video_cards.name as vdcrd_name, video_cards.price as vdcrd_price, video_cards.size as vdcrd_size, video_cards.clockRate as vdcrd_clockRate, video_cards.wattage as vdcrd_wattage, video_cards.videoMemory as vdcrd_videoMemory, video_cards.typeVideoMemory as vdcrd_typeVideoMemory, video_cards.photo as vdcrd_photo 
            FROM Pc 
            JOIN cpus On  Pc.cpu = cpus.id  
            JOIN coolers On Pc.cooler = coolers.id 
            JOIN hard_drives On Pc.hardDrive = hard_drives.id 
            JOIN motherboards ON Pc.motherboard = motherboards.id 
            JOIN pc_cases ON Pc.pcCase = pc_cases.id 
            JOIN psus ON Pc.psu = psus.id 
            JOIN rams ON Pc.ram = rams.id 
            JOIN video_cards ON Pc.videoCard = video_cards.id""")
    fun getPc(): Flow<List<PcWithData>>

    @Query("""SELECT Pc.id, Pc.name, Pc.price,
            cpus.id as cpu_id, cpus.name as cpu_name, cpus.price as cpu_price, cpus.socket as cpu_socket, cpus.clockRate as cpu_clockRate, cpus.wattage as cpu_wattage, cpus.photo as cpu_photo, 
            coolers.id as clr_id, coolers.name as clr_name, coolers.price as clr_price, coolers.heatSink as clr_heatSink, coolers.size as clr_size, coolers.socket as clr_socket, coolers.photo as clr_photo, 
            hard_drives.id as hd_id, hard_drives.name as hd_name, hard_drives.price as hd_price, hard_drives.capacity as hd_capacity, hard_drives.type as hd_type, hard_drives.size as hd_size, hard_drives.overwrite as hd_overwrite, hard_drives.photo as hd_photo, 
            motherboards.id as mthb_id, motherboards.name as mthb_name, motherboards.price as mthb_price, motherboards.size as mthb_size, motherboards.socket as mthb_socket, motherboards.photo as mthb_photo, 
            pc_cases.id as pcc_id, pc_cases.name as pcc_name, pc_cases.price as pcc_price, pc_cases.size as pcc_size, pc_cases.photo as pcc_photo, 
            psus.id as psu_id, psus.name as psu_name, psus.price as psu_price, psus.wattage as psu_wattage, psus.pinCPU as psu_pinCPU, psus.pinPCIE as psu_pinPCIE, psus.photo as psu_photo, 
            rams.id as ram_id, rams.name as ram_name, rams.price as ram_price, rams.clockRate as ram_clockRate, rams.type as ram_type, rams.photo as ram_photo, 
            video_cards.id as vdcrd_id, video_cards.name as vdcrd_name, video_cards.price as vdcrd_price, video_cards.size as vdcrd_size, video_cards.clockRate as vdcrd_clockRate, video_cards.wattage as vdcrd_wattage, video_cards.videoMemory as vdcrd_videoMemory, video_cards.typeVideoMemory as vdcrd_typeVideoMemory, video_cards.photo as vdcrd_photo 
            FROM Pc 
            JOIN cpus On  Pc.cpu = cpus.id  
            JOIN coolers On Pc.cooler = coolers.id 
            JOIN hard_drives On Pc.hardDrive = hard_drives.id 
            JOIN motherboards ON Pc.motherboard = motherboards.id 
            JOIN pc_cases ON Pc.pcCase = pc_cases.id 
            JOIN psus ON Pc.psu = psus.id 
            JOIN rams ON Pc.ram = rams.id 
            JOIN video_cards ON Pc.videoCard = video_cards.id
            WHERE Pc.id = :id""")
    fun getPc(id : Int): PcWithData

    @Insert
    fun insertPc(pc: PcEntity)

    @Update
    fun updatePc(pc: PcEntity)

    @Delete
    fun deletePc(pc: PcEntity)
}