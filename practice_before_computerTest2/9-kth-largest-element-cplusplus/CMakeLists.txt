set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_STANDARD 11)
set(PROJECT_NAME cppmain)
project(${PROJECT_NAME})
include_directories(include)
aux_source_directory(src SRCS)
aux_source_directory(test TEST_SRCS)
add_executable(${PROJECT_NAME} ${SRCS} ${TEST_SRCS})

find_package(GTest REQUIRED)
# GTest 的头文件
include_directories(${GTEST_INCLUDE_DIRS})
target_link_libraries( ${PROJECT_NAME}
        ${GTEST_BOTH_LIBRARIES}
        pthread )