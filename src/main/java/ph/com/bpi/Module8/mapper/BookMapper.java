package ph.com.bpi.Module8.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

import ph.com.bpi.Module8.dto.BookDTO;
import ph.com.bpi.Module8.model.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    
    // Map Entity → DTO
    @Mapping(target = "title", source = "title")
    @Mapping(target = "author", source = "author")
    BookDTO toDTO(BookEntity book);
    
    @Mapping(target = "id", ignore = true) // ignore ID when creating new entity
    BookEntity toEntity(BookDTO bookDto);

}