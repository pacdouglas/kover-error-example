package org.kover

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FooTest {
    @Test
    fun `testing foo`() {
        assertEquals(1, Foo().run())
    }
}