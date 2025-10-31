# Padrão Prototype

---

**Categoria**: Criacional

---

## O que é?

O **Prototype** é um padrão de projeto criacional que permite copiar objetos existentes sem tornar o código dependente de suas classes concretas. Em vez de criar novos objetos usando `new`, você clona objetos pré-existentes.

> 💡 **Analogia**: Pense em células biológicas que se duplicam por mitose. Cada célula nova é uma cópia da célula original, com o mesmo DNA, mas é uma entidade independente.

## Estrutura

```
┌─────────────────────────────────────┐
│       <<interface/abstract>>        │
│            Prototype                │
├─────────────────────────────────────┤
│ + clone(): Prototype                │
└─────────────────────────────────────┘
                 △
                 │ implementa
    ┌────────────┴────────────┐
    │                         │
┌───────────────┐    ┌───────────────┐
│ ConcreteA     │    │ ConcreteB     │
├───────────────┤    ├───────────────┤
│ - field1      │    │ - field2      │
│ + clone()     │    │ + clone()     │
└───────────────┘    └───────────────┘
```

## Problema que resolve

### Cenário problemático:
```java
// Criação complexa e acoplada
Guerreiro g1 = new Guerreiro();
g1.setX(100);
g1.setY(200);
g1.setPoder(500);
g1.configurarAnimacoes();
g1.carregarTexturas();

// Para criar outro similar, preciso repetir tudo!
Guerreiro g2 = new Guerreiro();
g2.setX(100);
g2.setY(200);
g2.setPoder(500);
g2.configurarAnimacoes();
g2.carregarTexturas();
```

### Problemas:
1. **Duplicação de código** na criação de objetos similares
2. **Dependência de classes concretas** - você precisa conhecer a classe exata
3. **Inicialização complexa** precisa ser repetida
4. **Objetos com estado privado** podem ser impossíveis de replicar externamente

### Solução com Prototype:
```java
Guerreiro g2 = g1.clone(); // Cópia rápida e independente
```

## Quando usar

✅ **Use Prototype quando:**
- Você precisa criar muitos objetos similares com configurações parecidas
- A criação de objetos é cara (recursos, tempo, complexidade)
- As classes a serem instanciadas são especificadas em tempo de execução
- Você quer evitar hierarquias de factories paralelas às classes de produtos
- Objetos têm poucos estados diferentes possíveis

❌ **Evite quando:**
- Objetos são simples e baratos de criar do zero
- Clonar objetos com referências circulares é complexo demais
- Objetos não devem ser copiados por questões de negócio (ex: entidades únicas)


## Vantagens e Desvantagens

### ✅ Vantagens

1. **Reduz a necessidade de subclasses** para variações de objetos
2. **Oculta complexidade de criação** do cliente
3. **Performance**: Clonar pode ser mais rápido que criar do zero
4. **Flexibilidade**: Adiciona/remove protótipos em runtime
5. **Alternativa à herança** para configurar objetos

### ❌ Desvantagens

1. **Cópia profunda complexa**: Objetos com referências circulares são difíceis de clonar
2. **Clone pode ser problemático**: Muitos desenvolvedores evitam `Cloneable` por ser frágil
3. **Dependências não óbvias**: Pode não ficar claro que objetos compartilham estrutura
4. **Violação de encapsulamento**: Subclasses precisam conhecer detalhes de clonagem

## 🎓 Conceitos Importantes

### Shallow Copy vs Deep Copy

**Shallow Copy** (Cópia Rasa):
```java
// super.clone() faz shallow copy
ElementoJogo clone = (ElementoJogo) super.clone();
// Campos primitivos são copiados
// Referências apontam para os MESMOS objetos
```

**Deep Copy** (Cópia Profunda):
```java
@Override
public ElementoJogo clone() throws CloneNotSupportedException {
    ElementoJogo clone = (ElementoJogo) super.clone();
    // Clonar objetos referenciados também
    clone.armas = new ArrayList<>(this.armas);
    return clone;
}
```

### Registry Pattern (complementar)

Prototypes geralmente são usados com um **Prototype Registry**, um map/cache que armazena 
protótipos pré-configurados para facilitar o uso:

```java
public class RegistroElementos {
    private Map<String, ElementoJogo> prototipos = new HashMap<>();

    public void registrar(String chave, ElementoJogo prototipo) {
        prototipos.put(chave, prototipo);
    }

    public ElementoJogo criar(String chave) {
        return prototipos.get(chave).clone();
    }
}

// Uso:
registro.registrar("guerreiro", new Guerreiro());
registro.registrar("general", new General());
registro.registrar("mago", new Mago());

ElementoJogo e = registro.criar("guerreiro"); // Clona!
```

## 📚 Relação com outros padrões

- **Abstract Factory**: Prototype pode ser uma alternativa mais simples
- **Composite**: Frequentemente usa Prototype para clonar estruturas complexas
- **Decorator**: Prototypes podem ser decorados antes de serem registrados
