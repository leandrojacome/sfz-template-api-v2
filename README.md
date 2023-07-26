# sfz-template-api

## Guia de uso

### Construção do projeto (sem testes)
```bash
./mvnw package -DskipTests
```

### Execução dos testes
```bash
./mvnw verirfy
```

### Construção e publicação da imagem Docker
```bash
./mvnw jib:build
```

