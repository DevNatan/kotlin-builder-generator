package me.devnatan.kbg

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.isAnnotationPresent
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.google.devtools.ksp.symbol.KSAnnotated

class KBGAnnotationProcessor(private val codeGenerator: CodeGenerator, private val logger: KSPLogger) :
    SymbolProcessor {
    private var invoked = false

    @OptIn(KspExperimental::class)
    override fun process(resolver: Resolver): List<KSAnnotated> {
        if (invoked) return emptyList()

        invoked = true

        val visitor = KBGVisitor(codeGenerator)
        resolver.getAllFiles()
            .filter { declaration -> declaration.isAnnotationPresent(GenerateBuilder::class) }
            .forEach { declaration -> declaration.accept(visitor, Unit) }

        return emptyList()
    }
}

class KBGAnnotationProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor = KBGAnnotationProcessor(
        codeGenerator = environment.codeGenerator,
        logger = environment.logger
    )
}