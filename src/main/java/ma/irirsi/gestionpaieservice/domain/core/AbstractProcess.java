package ma.irirsi.gestionpaieservice.domain.core;

public interface AbstractProcess<T extends AbstractProcessInput> {
    Result execute(T abstractProcessInput);
}
