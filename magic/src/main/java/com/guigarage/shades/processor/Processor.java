package com.guigarage.shades.processor;

import com.sun.source.util.Trees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.TypeTag;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree.JCBlock;
import com.sun.tools.javac.tree.JCTree.JCClassDecl;
import com.sun.tools.javac.tree.JCTree.JCExpression;
import com.sun.tools.javac.tree.JCTree.JCMethodDecl;
import com.sun.tools.javac.tree.JCTree.JCModifiers;
import com.sun.tools.javac.tree.JCTree.JCStatement;
import com.sun.tools.javac.tree.JCTree.JCTypeParameter;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Name;
import com.sun.tools.javac.util.Names;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SupportedAnnotationTypes("java.lang.Deprecated")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class Processor extends AbstractProcessor {

    private TreeMaker treeMaker;

    private Trees trees;

    private Context context;

    @Override
    public void init(ProcessingEnvironment procenv) {
        print("Step 1");
        context = ((JavacProcessingEnvironment) procenv).getContext();
        trees = Trees.instance(procenv);
        treeMaker = TreeMaker.instance(context);
        print("Step 2");
        super.init(procenv);
        print("Step 3");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //getAllClasses(roundEnv).forEach(jcClassDecl -> addHelloMethod(jcClassDecl));
        getAllClasses(roundEnv).forEach(jcClassDecl -> addMaybeField(jcClassDecl));
        return true;
    }

    private List<JCClassDecl> getAllClasses(RoundEnvironment roundEnv) {
        return roundEnv.getRootElements().stream()
                .map(element -> trees.getTree(element))
                .filter(tree -> tree instanceof JCClassDecl)
                .map(tree -> (JCClassDecl) tree)
                .collect(Collectors.toList());
    }

    private void addHelloMethod(JCClassDecl jcClassDecl) {
        JCModifiers modifiers = treeMaker.Modifiers(Flags.PRIVATE | Flags.FINAL);
        JCExpression returnType = treeMaker.TypeIdent(TypeTag.VOID);
        com.sun.tools.javac.util.List<JCVariableDecl> parameters = com.sun.tools.javac.util.List.nil();
        com.sun.tools.javac.util.List<JCTypeParameter> generics = com.sun.tools.javac.util.List.nil();
        Name methodName = getName("printHello");
        com.sun.tools.javac.util.List<JCExpression> throwz = com.sun.tools.javac.util.List.nil();
        JCBlock methodBody = makeHelloBody();
        JCMethodDecl helloMethodDecl =
                treeMaker.MethodDef(modifiers, methodName, returnType, generics, parameters, throwz,
                        methodBody, null);
        jcClassDecl.defs = jcClassDecl.defs.append(helloMethodDecl);

        System.err.println(jcClassDecl);
    }

    private JCBlock makeHelloBody() {
        JCExpression printExpression = treeMaker.Ident(getName("System"));
        printExpression = treeMaker.Select(printExpression, getName("out"));
        printExpression = treeMaker.Select(printExpression, getName("println"));
        com.sun.tools.javac.util.List<JCExpression> printArgs = com.sun.tools.javac.util.List.from(new JCExpression[]{treeMaker.Literal("Hello from HelloProcessor!")});
        printExpression = treeMaker.Apply(com.sun.tools.javac.util.List.<JCExpression>nil(), printExpression, printArgs);
        JCStatement call = treeMaker.Exec(printExpression);
        com.sun.tools.javac.util.List<JCStatement> statements = com.sun.tools.javac.util.List.from(new JCStatement[]{call});
        return treeMaker.Block(0, statements);
    }


    private Name getName(String string) {
        Names names = Names.instance(context);
        return names.fromString(string);
    }

    private void addMaybeField(JCClassDecl jcClassDecl) {
        JCVariableDecl variableDecl = createMaybeField();
        jcClassDecl.defs = jcClassDecl.defs.append(variableDecl);
        System.err.println(jcClassDecl);
    }

    private JCVariableDecl createMaybeField() {
        JCModifiers varModifiers = treeMaker.Modifiers(Flags.PRIVATE | Flags.STATIC | Flags.FINAL);
        JCExpression ident = treeMaker.TypeIdent(TypeTag.BOOLEAN);
        JCExpression initialValue = treeMaker.Literal(Math.random() < 0.5);
        return treeMaker.VarDef(varModifiers, getName("maybe"), ident, initialValue);
    }

    private static void print(String s) {
        System.err.println("--------------------> " + s);
    }
}
