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
    @Query("""SELECT 
    pc.id,
    pc.name,
    pc.price,
    -- Кулеры: ID, названия, количества
    GROUP_CONCAT(DISTINCT cooler.id) AS clr_id,
    GROUP_CONCAT(DISTINCT cooler.name) AS clr_name,
    GROUP_CONCAT(DISTINCT q_cooler.quantity) AS clr_quantity,
    -- Оперативная память: ID, названия, количества
    GROUP_CONCAT(DISTINCT ram.id) AS ram_id,
    GROUP_CONCAT(DISTINCT ram.name) AS ram_name,
    GROUP_CONCAT(DISTINCT q_ram.quantity) AS ram_quantity,
	-- Материнская память : ID, названия, количества
    GROUP_CONCAT(DISTINCT motherboard.id) AS mthb_id,
    GROUP_CONCAT(DISTINCT motherboard.name) AS mthb_name,
    GROUP_CONCAT(DISTINCT q_motherboard.quantity) AS mthb_quantity,
	-- Видео карта: ID, названия, количества
    GROUP_CONCAT(DISTINCT video_card.id) AS vdcrd_id,
    GROUP_CONCAT(DISTINCT video_card.name) AS vdcrd_name,
    GROUP_CONCAT(DISTINCT q_video_card.quantity) AS vdcrd_quantity,
	-- Жёсткий диск: ID, названия, количества
    GROUP_CONCAT(DISTINCT hard_drive.id) AS hd_id,
    GROUP_CONCAT(DISTINCT hard_drive.name) AS hd_name,
    GROUP_CONCAT(DISTINCT q_hard_drive.quantity) AS hd_quantity,
	-- Корпус: ID, названия, количества
    GROUP_CONCAT(DISTINCT pc_case.id) AS pcc_id,
    GROUP_CONCAT(DISTINCT pc_case.name) AS pcc_name,
    GROUP_CONCAT(DISTINCT q_case.quantity) AS pcc_quantity,
		-- Процессор: ID, названия, количества
    GROUP_CONCAT(DISTINCT cpu.id) AS cpu_id,
    GROUP_CONCAT(DISTINCT cpu.name) AS cpu_name,
    GROUP_CONCAT(DISTINCT q_cpu.quantity) AS cpu_quantity,
	-- Блок питания: ID, названия, количества
    GROUP_CONCAT(DISTINCT psu.id) AS psu_id,
    GROUP_CONCAT(DISTINCT psu.name) AS psu_name,
    GROUP_CONCAT(DISTINCT q_psu.quantity) AS psu_quantity

FROM pc

LEFT JOIN q_cooler ON pc.id = q_cooler.pc_id
LEFT JOIN cooler ON q_cooler.cooler_id = cooler.id

LEFT JOIN q_ram ON pc.id = q_ram.pc_id
LEFT JOIN ram ON q_ram.ram_id = ram.id

LEFT JOIN q_motherboard ON pc.id = q_motherboard.pc_id
LEFT JOIN motherboard ON q_motherboard.motherboard_id = motherboard.id

LEFT JOIN q_video_card ON pc.id = q_video_card.pc_id
LEFT JOIN video_card ON q_video_card.video_card_id = video_card.id

LEFT JOIN q_hard_drive ON pc.id = q_hard_drive.pc_id
LEFT JOIN hard_drive ON q_hard_drive.hard_drive_id = hard_drive.id

LEFT JOIN q_case ON pc.id = q_case.pc_id
LEFT JOIN pc_case ON q_case.case_id = pc_case.id

LEFT JOIN q_cpu ON pc.id = q_cpu.pc_id
LEFT JOIN cpu ON q_cpu.cpu_id = cpu.id

LEFT JOIN q_psu ON pc.id = q_psu.pc_id
LEFT JOIN psu ON q_psu.psu_id = psu.id

GROUP BY pc.id, pc.name, pc.price;""")
    fun getPc(): Flow<List<PcWithData>>

    @Query("""SELECT 
    pc.id,
    pc.name,
    pc.price,
    -- Кулеры: ID, названия, количества
    GROUP_CONCAT(DISTINCT cooler.id) AS clr_id,
    GROUP_CONCAT(DISTINCT cooler.name) AS clr_name,
    GROUP_CONCAT(DISTINCT q_cooler.quantity) AS clr_quantity,
    -- Оперативная память: ID, названия, количества
    GROUP_CONCAT(DISTINCT ram.id) AS ram_id,
    GROUP_CONCAT(DISTINCT ram.name) AS ram_name,
    GROUP_CONCAT(DISTINCT q_ram.quantity) AS ram_quantity,
	-- Материнская память : ID, названия, количества
    GROUP_CONCAT(DISTINCT motherboard.id) AS mthb_id,
    GROUP_CONCAT(DISTINCT motherboard.name) AS mthb_name,
    GROUP_CONCAT(DISTINCT q_motherboard.quantity) AS mthb_quantity,
	-- Видео карта: ID, названия, количества
    GROUP_CONCAT(DISTINCT video_card.id) AS vdcrd_id,
    GROUP_CONCAT(DISTINCT video_card.name) AS vdcrd_name,
    GROUP_CONCAT(DISTINCT q_video_card.quantity) AS vdcrd_quantity,
	-- Жёсткий диск: ID, названия, количества
    GROUP_CONCAT(DISTINCT hard_drive.id) AS hd_id,
    GROUP_CONCAT(DISTINCT hard_drive.name) AS hd_name,
    GROUP_CONCAT(DISTINCT q_hard_drive.quantity) AS hd_quantity,
	-- Корпус: ID, названия, количества
    GROUP_CONCAT(DISTINCT pc_case.id) AS pcc_id,
    GROUP_CONCAT(DISTINCT pc_case.name) AS pcc_name,
    GROUP_CONCAT(DISTINCT q_case.quantity) AS pcc_quantity,
		-- Процессор: ID, названия, количества
    GROUP_CONCAT(DISTINCT cpu.id) AS cpu_id,
    GROUP_CONCAT(DISTINCT cpu.name) AS cpu_name,
    GROUP_CONCAT(DISTINCT q_cpu.quantity) AS cpu_quantity,
	-- Блок питания: ID, названия, количества
    GROUP_CONCAT(DISTINCT psu.id) AS psu_id,
    GROUP_CONCAT(DISTINCT psu.name) AS psu_name,
    GROUP_CONCAT(DISTINCT q_psu.quantity) AS psu_quantity

FROM pc

LEFT JOIN q_cooler ON pc.id = q_cooler.pc_id
LEFT JOIN cooler ON q_cooler.cooler_id = cooler.id

LEFT JOIN q_ram ON pc.id = q_ram.pc_id
LEFT JOIN ram ON q_ram.ram_id = ram.id

LEFT JOIN q_motherboard ON pc.id = q_motherboard.pc_id
LEFT JOIN motherboard ON q_motherboard.motherboard_id = motherboard.id

LEFT JOIN q_video_card ON pc.id = q_video_card.pc_id
LEFT JOIN video_card ON q_video_card.video_card_id = video_card.id

LEFT JOIN q_hard_drive ON pc.id = q_hard_drive.pc_id
LEFT JOIN hard_drive ON q_hard_drive.hard_drive_id = hard_drive.id

LEFT JOIN q_case ON pc.id = q_case.pc_id
LEFT JOIN pc_case ON q_case.case_id = pc_case.id

LEFT JOIN q_cpu ON pc.id = q_cpu.pc_id
LEFT JOIN cpu ON q_cpu.cpu_id = cpu.id

LEFT JOIN q_psu ON pc.id = q_psu.pc_id
LEFT JOIN psu ON q_psu.psu_id = psu.id
WHERE Pc.id = :id
GROUP BY pc.id, pc.name, pc.price;
            """)
    fun getPc(id : Int): PcWithData

    @Insert
    fun insertPc(pc: PcEntity)

    @Update
    fun updatePc(pc: PcEntity)

    @Delete
    fun deletePc(pc: PcEntity)
}