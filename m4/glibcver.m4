dnl Copyright (C) 2004 The Kaffe.org's developers. See ChangeLog for details.
dnl See the file "license.terms" for information on usage and redistribution
dnl of this file.

dnl Copyright (C) 2000-2002 Free Software Foundation, Inc.
dnl This file is free software, distributed under the terms of the GNU
dnl General Public License.  As a special exception to the GNU General
dnl Public License, this file may be distributed as part of a program
dnl that contains a configuration script generated by Autoconf, under
dnl the same distribution terms as the rest of that program.

# Test for the GNU C Library, version 2.1 or newer.
# From Bruno Haible.

AC_DEFUN([KAFFE_CHECK_GLIBC_VER],
[
    AC_CACHE_CHECK(whether we are using the GNU C Library $1.$2 or later,
      ac_cv_gnu_library_$1_$2,
      [AC_EGREP_CPP([Lucky GNU user],
        [
#include <features.h>
#ifdef __GNU_LIBRARY__
 #if (__GLIBC__ == $1 && __GLIBC_MINOR__ >= $2) || (__GLIBC__ > $1)
  Lucky GNU user
 #endif
#endif
        ],
        ac_cv_gnu_library_$1_$2=yes,
        ac_cv_gnu_library_$1_$2=no)
      ]
    )
  ]
)