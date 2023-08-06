package me.devnatan.kbg

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.isAnnotationPresent
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid

class KBGVisitor(private val codeGenerator: CodeGenerator) : KSVisitorVoid() {

    @OptIn(KspExperimental::class)
    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        super.visitAnnotated(classDeclaration, data)

        if (!classDeclaration.isAnnotationPresent(GenerateBuilder::class))
            return


    }
}