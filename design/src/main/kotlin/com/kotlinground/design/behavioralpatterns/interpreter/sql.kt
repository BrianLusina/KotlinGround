package com.kotlinground.design.behavioralpatterns.interpreter

fun select(columns: String, from: SelectClause.() -> Unit): SelectClause {
    return SelectClause(columns).apply(from)
}

class SelectClause(private val columns: String) {
    private lateinit var from: FromClause

    fun from(table: String, where: FromClause.() -> Unit): FromClause {
        // could be shortened to FromClause(table).apply(where)
        from = FromClause(table)
        return from.apply(where)
    }

    override fun toString(): String = "SELECT $columns $from"
}

class FromClause(private val table: String) {
    private lateinit var where: WhereClause

    fun where(conditions: String) = apply {
        where = WhereClause(conditions)
    }

    override fun toString(): String = "FROM $table $where"
}

class WhereClause(private val conditions: String) {
    override fun toString(): String = "WHERE $conditions"
}

fun main() {

    val sql = select("name, age") {
        from("users") {
            where("age >25")
        }
    }

    print(sql)
}