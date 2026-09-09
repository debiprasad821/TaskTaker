package com.poc.`data`.local

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class TaskDao_Impl(
  __db: RoomDatabase,
) : TaskDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfTask: EntityInsertAdapter<Task>
  init {
    this.__db = __db
    this.__insertAdapterOfTask = object : EntityInsertAdapter<Task>() {
      protected override fun createQuery(): String = "INSERT OR ABORT INTO `Tasks` (`id`,`title`,`description`,`priority`,`dueDateTime`,`isCompleted`) VALUES (nullif(?, 0),?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Task) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.title)
        statement.bindText(3, entity.description)
        statement.bindText(4, entity.priority)
        val _tmpDueDateTime: Long? = entity.dueDateTime
        if (_tmpDueDateTime == null) {
          statement.bindNull(5)
        } else {
          statement.bindLong(5, _tmpDueDateTime)
        }
        val _tmp: Int = if (entity.isCompleted) 1 else 0
        statement.bindLong(6, _tmp.toLong())
      }
    }
  }

  public override suspend fun insertTask(task: Task): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfTask.insert(_connection, task)
  }

  public override fun getTasks(): Flow<List<Task>> {
    val _sql: String = "SELECT * FROM tasks"
    return createFlow(__db, false, arrayOf("tasks")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfDescription: Int = getColumnIndexOrThrow(_stmt, "description")
        val _columnIndexOfPriority: Int = getColumnIndexOrThrow(_stmt, "priority")
        val _columnIndexOfDueDateTime: Int = getColumnIndexOrThrow(_stmt, "dueDateTime")
        val _columnIndexOfIsCompleted: Int = getColumnIndexOrThrow(_stmt, "isCompleted")
        val _result: MutableList<Task> = mutableListOf()
        while (_stmt.step()) {
          val _item: Task
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpDescription: String
          _tmpDescription = _stmt.getText(_columnIndexOfDescription)
          val _tmpPriority: String
          _tmpPriority = _stmt.getText(_columnIndexOfPriority)
          val _tmpDueDateTime: Long?
          if (_stmt.isNull(_columnIndexOfDueDateTime)) {
            _tmpDueDateTime = null
          } else {
            _tmpDueDateTime = _stmt.getLong(_columnIndexOfDueDateTime)
          }
          val _tmpIsCompleted: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsCompleted).toInt()
          _tmpIsCompleted = _tmp != 0
          _item = Task(_tmpId,_tmpTitle,_tmpDescription,_tmpPriority,_tmpDueDateTime,_tmpIsCompleted)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
