package com.mob.lee.fastair.model

import android.content.Context
import android.text.format.Formatter
import java.text.SimpleDateFormat

/**
 * Created by Andy on 2017/6/2.
 */

val MESSAGE_TEXT = 1

val PICTURE = 1
val VIDEO = 2
val MUSIC = 3
val WORD = 4
val EXCEL = 5
val POWERPOINT = 6
val PDF = 7
val TXT = 8
val ZIP = 9
val APPLICATION = 10
val OTHER = 11
val CHAT = 12

val HOST = "host"
val ADDRESS = "address"
val IS_HOST = "isHost"
val IS_CHAT = "isChat"
val IS_SEND = "isSend"
val PORT="port"
val MESSAGE = "message"
val FILE = "file"
const val FILES="files"
const val COUNT="count"
val HOST_TO = "hostTO"
val CONNECTION_PORT="connectionPort"
val PORT_MESSAGE=65514
val PORT_FILE=65515
const val TEXT=1
const val BINNARY= 2

/*文件状态*/
/*原始状态，即本机文件*/
const val STATE_ORIGIN=0

/*选中状态*/
const val STATE_CHECK=1

/*准备传输状态*/
const val STATE_WAIT=2

/*传输中*/
const val STATE_TRANSPORT=3

/*传输成功状态*/
const val STATE_SUCCESS=4

/*传输失败状态*/
const val STATE_FAILED=5

fun parseCategory(path: String): FileCategory {

    val index = path.lastIndexOf(char = '.', ignoreCase = true)
    if (0 < index) {
        when (path.substring(index).toLowerCase()) {
            ".jpg", ".png", ".gif", ".webp", ".jpeg", ".bmp" -> return FileCategory(PICTURE)
            ".wmv", ".mp4", ".mkv", ".3gp", ".avi", ".flv", ".rm", ".rmvb", ".mpeg" -> return FileCategory(VIDEO)
            ".flac", ".mp3", ".wma", ".ogg", ".aiff" -> return FileCategory(MUSIC)
            ".doc", ".docx" -> return FileCategory(WORD)
            ".xls", "xlsx" -> return FileCategory(EXCEL)
            ".ppt", ".pptx" -> return FileCategory(POWERPOINT)
            ".pdf" -> return FileCategory(PDF)
            ".txt" -> return FileCategory(TXT)
            ".zip", ".rar", ".iso", ".7z" -> return FileCategory(ZIP)
            ".apk" -> return FileCategory(APPLICATION)
            else -> return FileCategory(OTHER)
        }
    }
    return FileCategory(OTHER)
}

fun category():List<FileCategory>{
    val categories=ArrayList<FileCategory>()
    categories.add(FileCategory(PICTURE))
    categories.add(FileCategory(VIDEO))
    categories.add(FileCategory(MUSIC))
    categories.add(FileCategory(WORD))
    categories.add(FileCategory(EXCEL))
    categories.add(FileCategory(POWERPOINT))
    categories.add(FileCategory(PDF))
    categories.add(FileCategory(TXT))
    categories.add(FileCategory(ZIP))
    categories.add(FileCategory(APPLICATION))
    categories.add(FileCategory(OTHER))
    categories.add(FileCategory(CHAT))
    return categories
}

fun Long.formatDate(parttern:String="MM/dd/yyyy HH:mm"):String{
    val formater=SimpleDateFormat(parttern)
    return formater.format(this)
}

fun Long.formatSize(context:Context):String{
    return Formatter.formatFileSize(context,this)
}