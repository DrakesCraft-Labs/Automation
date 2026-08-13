package io.github.seggan.automation.computing.metis

import io.github.seggan.automation.computing.peripherals.Peripherals
import io.github.seggan.metis.runtime.State

fun State.preinit() {
    addNativeLibrary(Peripherals)
}