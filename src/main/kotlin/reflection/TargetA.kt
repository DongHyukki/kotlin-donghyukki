package reflection

import kotlin.properties.Delegates

class TargetA(
    private val val1: String = "val1",
    private val val2: Long = 1L,
    private val val3: Int = 2,
) {
    lateinit var val4: String
    private val val5 by lazy { "val5_value" }
    var val6 by Delegates.notNull<String>()
    var val7: String = "val7_value"
    val val8 by lazy { "val8_value" }
}