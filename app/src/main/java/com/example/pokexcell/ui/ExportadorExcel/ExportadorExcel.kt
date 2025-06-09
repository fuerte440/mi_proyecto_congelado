package com.example.pokexcell.ui.ExportadorExcel

import android.content.ContentValues
import android.content.ContentResolver
import android.content.Context
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pokexcell.data.model.CartaConCantidad
import org.apache.poi.ss.usermodel.*
import org.apache.poi.util.IOUtils
import org.apache.poi.xssf.usermodel.XSSFClientAnchor
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream
import java.net.URL

object ExportadorExcel {

    fun exportarLista(context: Context, cartas: List<CartaConCantidad>) {
        if (cartas.isEmpty()) {
            Toast.makeText(context, "No hay cartas para exportar", Toast.LENGTH_SHORT).show()
            return
        }

        Thread {
            try {
                val workbook = XSSFWorkbook()
                val hoja = workbook.createSheet("Mi colección")
                val helper = workbook.creationHelper
                val drawing = hoja.createDrawingPatriarch()

                // Estilo de cabecera
                val headerFont = workbook.createFont().apply {
                    bold = true
                    color = IndexedColors.WHITE.index
                }

                val headerStyle = workbook.createCellStyle().apply {
                    fillForegroundColor = IndexedColors.LIGHT_CORNFLOWER_BLUE.index
                    fillPattern = FillPatternType.SOLID_FOREGROUND
                    setFont(headerFont)
                    alignment = HorizontalAlignment.CENTER
                    verticalAlignment = VerticalAlignment.CENTER
                    borderBottom = BorderStyle.THIN
                    borderTop = BorderStyle.THIN
                    borderLeft = BorderStyle.THIN
                    borderRight = BorderStyle.THIN
                }

                // Estilo de celdas
                val baseCellStyle = workbook.createCellStyle().apply {
                    wrapText = true
                    alignment = HorizontalAlignment.CENTER
                    verticalAlignment = VerticalAlignment.CENTER
                    borderBottom = BorderStyle.THIN
                    borderTop = BorderStyle.THIN
                    borderLeft = BorderStyle.THIN
                    borderRight = BorderStyle.THIN
                }

                val zebraStyle = workbook.createCellStyle().apply {
                    cloneStyleFrom(baseCellStyle)
                    fillForegroundColor = IndexedColors.GREY_25_PERCENT.index
                    fillPattern = FillPatternType.SOLID_FOREGROUND
                }

                // Fila cabecera
                val filaCabecera = hoja.createRow(0)
                val headers = listOf("Imagen", "Nombre", "Número", "Rareza", "Dibujante", "Cantidad")
                headers.forEachIndexed { i, h ->
                    val cell = filaCabecera.createCell(i)
                    cell.setCellValue(h)
                    cell.cellStyle = headerStyle
                }

                // Filas de contenido
                for ((index, carta) in cartas.withIndex()) {
                    val fila = hoja.createRow(index + 1)
                    fila.heightInPoints = 100f
                    val estilo = if ((index + 1) % 2 == 0) zebraStyle else baseCellStyle

                    try {
                        val url = URL(carta.carta.url_imagen)
                        val bytes = url.openStream().use { IOUtils.toByteArray(it) }

                        if (bytes.isNotEmpty()) {
                            val pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG)
                            val anchor = helper.createClientAnchor() as XSSFClientAnchor
                            anchor.setCol1(0)
                            anchor.row1 = index + 1
                            anchor.setCol2(1)
                            anchor.row2 = index + 2
                            drawing.createPicture(anchor, pictureIdx)
                        }
                    } catch (e: Exception) {
                        Log.e("ExportarExcel", "Error imagen: ${e.message}")
                    }

                    fila.createCell(1).apply {
                        setCellValue(carta.carta.nombre)
                        cellStyle = estilo
                    }
                    fila.createCell(2).apply {
                        setCellValue(carta.carta.numero_carta)
                        cellStyle = estilo
                    }
                    fila.createCell(3).apply {
                        setCellValue(carta.carta.rareza)
                        cellStyle = estilo
                    }
                    fila.createCell(4).apply {
                        setCellValue(carta.carta.dibujante)
                        cellStyle = estilo
                    }
                    fila.createCell(5).apply {
                        setCellValue(carta.cantidad.toString())
                        cellStyle = estilo
                    }
                }

                hoja.createFreezePane(0, 1)
                hoja.setColumnWidth(0, 15 * 256)
                hoja.setColumnWidth(1, 20 * 256)
                hoja.setColumnWidth(2, 10 * 256)
                hoja.setColumnWidth(3, 15 * 256)
                hoja.setColumnWidth(4, 20 * 256)
                hoja.setColumnWidth(5, 8 * 256)

                val fileName = "Pokexcell_${System.currentTimeMillis()}.xlsx"
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    val contentValues = ContentValues().apply {
                        put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                        put(MediaStore.MediaColumns.MIME_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                        put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
                    }

                    val resolver: ContentResolver = context.contentResolver
                    val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)

                    uri?.let {
                        resolver.openOutputStream(it)?.use { output ->
                            workbook.write(output)
                        }
                    }
                } else {
                    val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    val file = File(path, fileName)
                    FileOutputStream(file).use { output ->
                        workbook.write(output)
                    }
                }

                workbook.close()
                (context as? AppCompatActivity)?.runOnUiThread {
                    Toast.makeText(context, "Colección exportada correctamente", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Log.e("ExportarExcel", "Error exportando Excel: ${e.message}")
                (context as? AppCompatActivity)?.runOnUiThread {
                    Toast.makeText(context, "Error al exportar: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }.start()
    }
}
