package me.devnatan.kbg

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import java.io.OutputStreamWriter

class KBGVisitor(private val codeGenerator: CodeGenerator) : KSVisitorVoid() {

    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        super.visitClassDeclaration(classDeclaration, data)

        codeGenerator.createNewFile(
            Dependencies(aggregating = false),
            classDeclaration.packageName.asString(),
            classDeclaration.simpleName.asString() + "Builder"
        ).use { output ->
            OutputStreamWriter(output).use { writer ->
                TODO()
            }
        }
    }
}