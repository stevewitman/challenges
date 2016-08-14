module Paths_images_edges2 (
    version,
    getBinDir, getLibDir, getDataDir, getLibexecDir,
    getDataFileName, getSysconfDir
  ) where

import qualified Control.Exception as Exception
import Data.Version (Version(..))
import System.Environment (getEnv)
import Prelude

catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
catchIO = Exception.catch

version :: Version
version = Version [0,1,0,0] []
bindir, libdir, datadir, libexecdir, sysconfdir :: FilePath

bindir     = "/Users/chrismwendt/sandbox/images-edges2/.stack-work/install/x86_64-osx/lts-6.10/7.10.3/bin"
libdir     = "/Users/chrismwendt/sandbox/images-edges2/.stack-work/install/x86_64-osx/lts-6.10/7.10.3/lib/x86_64-osx-ghc-7.10.3/images-edges2-0.1.0.0-19xQhYn6w7KFO5dj5m8S85"
datadir    = "/Users/chrismwendt/sandbox/images-edges2/.stack-work/install/x86_64-osx/lts-6.10/7.10.3/share/x86_64-osx-ghc-7.10.3/images-edges2-0.1.0.0"
libexecdir = "/Users/chrismwendt/sandbox/images-edges2/.stack-work/install/x86_64-osx/lts-6.10/7.10.3/libexec"
sysconfdir = "/Users/chrismwendt/sandbox/images-edges2/.stack-work/install/x86_64-osx/lts-6.10/7.10.3/etc"

getBinDir, getLibDir, getDataDir, getLibexecDir, getSysconfDir :: IO FilePath
getBinDir = catchIO (getEnv "images_edges2_bindir") (\_ -> return bindir)
getLibDir = catchIO (getEnv "images_edges2_libdir") (\_ -> return libdir)
getDataDir = catchIO (getEnv "images_edges2_datadir") (\_ -> return datadir)
getLibexecDir = catchIO (getEnv "images_edges2_libexecdir") (\_ -> return libexecdir)
getSysconfDir = catchIO (getEnv "images_edges2_sysconfdir") (\_ -> return sysconfdir)

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir ++ "/" ++ name)
