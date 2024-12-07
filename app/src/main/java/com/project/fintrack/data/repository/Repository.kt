package com.project.fintrack.data.repository

import android.content.Context
import com.project.fintrack.data.dao.TransactionDao
import com.project.fintrack.data.db.LocalDatabase
import com.project.fintrack.data.models.TransactionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(context: Context) {
    private val transactionDao: TransactionDao = LocalDatabase.getDatabase(context).transactionDao()

    suspend fun getAllTransactions(): List<TransactionEntity> = withContext(Dispatchers.IO) {
        transactionDao.getAll()
    }

    suspend fun createTransaction(transaction: TransactionEntity) = withContext(Dispatchers.IO) {
        transactionDao.insert(transaction)
    }

    suspend fun updateTransaction(transaction: TransactionEntity) = withContext(Dispatchers.IO) {
        transactionDao.update(transaction)
    }

    suspend fun deleteTransaction(id: Int) = withContext(Dispatchers.IO) {
        transactionDao.delete(id)
    }
}
