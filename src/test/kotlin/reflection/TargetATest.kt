package reflection

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.IllegalCallableAccessException
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.kotlinProperty

internal class TargetATest  {

    @Test
    fun find_targetA_field_val1 () {
        val targetA = TargetA::class
        val members = targetA.members.toList()
        val field1 = members[0]
        val returnType = field1.returnType
        val name = field1.name
        val visibility = field1.visibility

        assertThat(returnType.toString()).isEqualTo("kotlin.String")
        assertThat(name).isEqualTo("val1")
        assertThat(visibility.toString()).isEqualTo("PRIVATE")
    }

    @Test
    fun find_targetA_field_val2 () {
        val targetA = TargetA::class
        val members = targetA.members.toList()
        val field2 = members[1]
        val returnType = field2.returnType
        val name = field2.name
        val visibility = field2.visibility

        assertThat(returnType.toString()).isEqualTo("kotlin.Long")
        assertThat(name).isEqualTo("val2")
        assertThat(visibility.toString()).isEqualTo("PRIVATE")
    }

    @Test
    fun find_targetA_field_val3 () {
        val targetA = TargetA::class
        val members = targetA.members.toList()
        val field3 = members[2]
        val returnType = field3.returnType
        val name = field3.name
        val visibility = field3.visibility

        assertThat(returnType.toString()).isEqualTo("kotlin.Int")
        assertThat(name).isEqualTo("val3")
        assertThat(visibility.toString()).isEqualTo("PRIVATE")
    }

    @Test
    fun find_targetA_field_val4 () {
        val targetA = TargetA::class
        val members = targetA.members.toList()
        val field4 = members[3]
        val returnType = field4.returnType
        val name = field4.name
        val visibility = field4.visibility

        assertThat(returnType.toString()).isEqualTo("kotlin.String")
        assertThat(name).isEqualTo("val4")
        assertThat(visibility.toString()).isEqualTo("PUBLIC")
    }

    @Test
    fun find_targetA_field_val6 () {
        val targetA = TargetA::class
        val members = targetA.members.toList()
        val field6 = members[5]
        val returnType = field6.returnType
        val name = field6.name
        val visibility = field6.visibility

        assertThat(returnType.toString()).isEqualTo("kotlin.String")
        assertThat(name).isEqualTo("val6")
        assertThat(visibility.toString()).isEqualTo("PUBLIC")
    }

    @Test
    fun find_targetA_field_val7 () {
        val targetA = TargetA::class
        val members = targetA.members.toList()
        val field7 = members[6]
        val returnType = field7.returnType
        val name = field7.name
        val visibility = field7.visibility
        assertThat(returnType.toString()).isEqualTo("kotlin.String")
        assertThat(name).isEqualTo("val7")
        assertThat(visibility.toString()).isEqualTo("PUBLIC")
    }

    @DisplayName("private 접근자에 대한 value 접근")
    @Test
    fun find_targetA_field_val5_value () {
        val targetA = TargetA()
        val targetAObj = targetA::class
        val memberProperties = targetAObj.memberProperties
        val find = memberProperties.find { it.name == "val5" }
        assertThatThrownBy {
            val value = find?.call(targetA)
        }.isInstanceOf(IllegalCallableAccessException::class.java)
    }

    @DisplayName("public 접근자에 대한 value 접근")
    @Test
    fun find_targetA_field_val7_value () {
        val targetA = TargetA()
        val targetAObj = targetA::class
        val memberProperties = targetAObj.memberProperties
        val find = memberProperties.find { it.name == "val7" }
        val value = find?.call(targetA)
        assertThat(value).isEqualTo("val7_value")
    }

    @DisplayName("public 접근자에 대한 lazy value 접근")
    @Test
    fun find_targetA_field_val8_value () {
        val targetA = TargetA()
        val targetAObj = targetA::class
        val memberProperties = targetAObj.memberProperties
        val find = memberProperties.find { it.name == "val8" }
        val value = find?.call(targetA)
        assertThat(value).isEqualTo("val8_value")
    }

    @Test
    fun find_targetA_field_val6_set_value () {
        val targetA = TargetA()
        val targetAObj = targetA::class
        val memberProperties = targetAObj.memberProperties
        val find = memberProperties.find { it.name == "val6" }
        find as KMutableProperty<*>
        find.setter.call(targetA, "val6_value")

        val value = find?.call(targetA)
        assertThat(value).isEqualTo("val6_value")
    }
}