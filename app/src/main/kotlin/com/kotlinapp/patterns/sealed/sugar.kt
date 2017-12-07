package com.kotlinapp.patterns.sealed

import com.kotlinapp.patterns.sealed.Contract.*
import com.kotlinapp.patterns.sealed.Employee.*
import java.util.*

/**
 * @author lusinabrian on 06/12/17.
 */
fun access(employee: Employee, contract: Contract) = when (contract to employee) {
    PROBATION to SENIOR_ENGINEER,
    PROBATION to REGULAR_ENGINEER ->
        NotGranted(AssertionError("Access not allowed on probation contract."))
    PERMANENT to SENIOR_ENGINEER,
    PERMANENT to REGULAR_ENGINEER,
    PERMANENT to JUNIOR_ENGINEER,
    CONTRACTOR to SENIOR_ENGINEER -> Granted(Date(1))
    CONTRACTOR to REGULAR_ENGINEER,
    PROBATION to JUNIOR_ENGINEER,
    CONTRACTOR to JUNIOR_ENGINEER -> Blocked("Access for junior contractors is blocked.")
    else -> throw AssertionError("Unsupported case of $employee and $contract")
}
