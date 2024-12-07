package com.project.fintrack.utils

import androidx.room.TypeConverter
import com.project.fintrack.data.models.TransactionCategory
import com.project.fintrack.data.models.TransactionType
import java.util.Date

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromTransactionCategory(value: String): TransactionCategory {
        return TransactionCategory.valueOf(value)
    }

    @TypeConverter
    fun toTransactionCategory(category: TransactionCategory): String {
        return category.name
    }

    @TypeConverter
    fun fromTransactionType(value: String): TransactionType {
        return TransactionType.valueOf(value)
    }

    @TypeConverter
    fun toTransactionType(type: TransactionType): String {
        return type.name
    }
}
