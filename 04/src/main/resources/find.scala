:paste
case class File(name: Symbol, size: Int, content: Symbol)
case class Directory(name: Symbol, contents: DirContents)
case class DirContents(files: List[File], dirs: List[Directory])

abstract class MaybePath
case class APath(path:List[Symbol]) extends MaybePath
case object NoPath extends MaybePath
